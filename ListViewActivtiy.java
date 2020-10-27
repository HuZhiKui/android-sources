package com.example.wordbook;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class ListViewActivtiy {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        switchPreference = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        initData();
    }
    private void initData() {
        //第一个参数表示刷新的那个圈是否缩放
        //第二个表示下来的最低位置
        //第三个表示下来的最高位置
        switchPreference.setProgressViewOffset(true, 10, 15);
        //刷新的颜色
        switchPreference.setColorSchemeResources(R.color.colorAccent);
        //
        switchPreference.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override


            public void onRefresh() {
                //因为涉及到主线程刷新，所以还是走runnable吧
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("TAG", "加载刷新后的数据");
                        recyAdapter.notifyDataSetChanged();
                        //停止刷新
                        switchPreference.setRefreshing(false);
                    }
                }, 3000);
            }
        });

        //查询所有的user对象
        userInfos = SQLiteDB.getInstance(this).getUsers();
        //根据userid查询user对象
//        userInfos = SQLiteDB.getInstance(this).selectByIdUser("2");

        Log.i("sel", "succ" + userInfos.get(0).getUsername());

        recyAdapter = new RecyAdapter(userInfos);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyAdapter);
    }
}
