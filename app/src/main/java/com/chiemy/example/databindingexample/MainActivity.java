package com.chiemy.example.databindingexample;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chiemy.example.databindingexample.bean.User;
import com.chiemy.example.databindingexample.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {
    private String[] titles = {"Observable", "Observable fileds", "observable collections"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // setContentView(R.layout.activity_main);
        // 官方文档说这种方式也可以,但是并没有用?
        // ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        // 这种方式是有效的
        // View root = getLayoutInflater().inflate(R.layout.activity_main, null);
        // setContentView(root);
        // ActivityMainBinding binding = ActivityMainBinding.bind(root);

        User user = new User();
        user.setFirstName("chiemy");
        user.setLastName("luo");

        binding.setUser(user);
        binding.setOnClicklistener(this);
        binding.setStyle(new Style());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.mainRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new MainRecyclerViewDecoration());
        recyclerView.setAdapter(new MainAdapter());
    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, ListItemBindingActivity.class);
        startActivity(intent);
    }


    private class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

        @Override
        public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MainViewHolder(getLayoutInflater().inflate(R.layout.main_list_item, parent, false));
        }

        @Override
        public void onBindViewHolder(MainViewHolder holder, int position) {
            holder.bind(titles[position]);
        }

        @Override
        public int getItemCount() {
            return titles.length;
        }
    }


    private class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textView;

        public MainViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        public void bind(String text){
            textView.setText(text);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
        }
    }

    private class MainRecyclerViewDecoration extends RecyclerView.ItemDecoration {
        private static final int DIVIDER_WIDTH = 1;
        private static final int DIVIDER_COLOR = Color.BLACK;
        private Paint dividerPaint;
        private Paint backgroundPaint;

        private MainRecyclerViewDecoration() {
            dividerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            dividerPaint.setColor(DIVIDER_COLOR);
            dividerPaint.setStrokeWidth(DIVIDER_WIDTH);

            backgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            backgroundPaint.setColor(Color.DKGRAY);
            backgroundPaint.setStyle(Paint.Style.FILL);
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            // 在这里可以设置item padding或margin的效果
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            // 在item view绘制之后绘制，所以会遮挡item view(可能的话)
        }

        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            // 在item view之后之前绘制，所以item view 会遮挡它
            drawVertical(c, parent);
        }

        /**
         * 绘制纵向 item 分割线
         *
         * @param canvas
         * @param parent
         */
        private void drawVertical(Canvas canvas, RecyclerView parent) {
            final int childSize = parent.getChildCount();
            for (int i = 0; i < childSize; i++) {
                final View child = parent.getChildAt(i);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
                final int y = child.getBottom() + layoutParams.bottomMargin;
                final int left = child.getLeft();
                final int right = child.getRight();
                canvas.drawLine(left, y, right, y, dividerPaint);
            }
        }

    }
}
