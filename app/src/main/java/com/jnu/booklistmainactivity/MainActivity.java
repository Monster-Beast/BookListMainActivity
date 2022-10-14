package com.jnu.booklistmainactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Book> data=new ArrayList<>();
    public MyAdapter myAdapter;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Book book=new Book();
        book.setCoverResourceId(R.drawable.book_2);
        book.setTitle("软件项目案例管理教程（第四版）");
        data.add(book);
        Book book2=new Book();
        book2.setCoverResourceId(R.drawable.book_no_name);
        book2.setTitle("创新工程实践");
        data.add(book2);
        Book book3=new Book();
        book3.setCoverResourceId(R.drawable.book_1);
        book3.setTitle("信息安全教学基础");
        data.add(book3);
        Log.d("monster",data.toString());


        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.rl);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         myAdapter=new MyAdapter(data);
        recyclerView.setAdapter(myAdapter);



    }

    private List<Book> getListBooks(List<Book> book) {
        return book;
    }

    public void CreateMenu(ContextMenu contextMenu) {
        int groupID = 0;
        int order = 0;
        int[] itemID = {1,2};

        for(int i=0;i<itemID.length;i++)
        {
            switch(itemID[i])
            {
                case 1:
                    contextMenu.add(groupID, itemID[i], order, "增加");
                    break;
                case 2:
                    contextMenu.add(groupID, itemID[i], order, "删除");
                    break;
                default:
                    break;
            }
        }

    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                add1more();
                myAdapter.notifyDataSetChanged();
                break;
            case 2:
                delthis();
                myAdapter.notifyDataSetChanged();
                break;
            default:
                break;
        }


        return super.onContextItemSelected(item);
    }

    private void delthis() {

        data.remove(myAdapter.getContextMenuPosition());
    }

    private void add1more() {
        data.add(data.get(myAdapter.getContextMenuPosition()));
    }
}
