package com.example.pooja.diy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerVIew;
    LinearLayoutManager layoutManager;
    videoadapter videoAdapter;

    diytypes[] details={

        new diytypes("diy clothes","pic1","jTvqOEmcZyU"),
        new diytypes("diy hacks","pic2","tuRw0owdl10"),
        new diytypes("diy makeup","pic3","4WEJBpfbz18"),
        new diytypes("diy school supplies","pic4","VVXDkltJnHQ"),
        new diytypes("diy room decor","pic5","86IK2B4elgg"),
        new diytypes("diy bday cards","pic6","X3gGWyXPVCs"),
        new diytypes("diy giftbox","pic7","lhvUI6MHWK0"),
        new diytypes("diy miniatures","pic8","eO7zbLwsOHg"),
        new diytypes("diy phone case","pic9","A1xYlLK5n0Y"),
        new diytypes("diy wall hanging","pic10","28WvuGPWGQs")

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extra=getIntent().getExtras();
        if(extra!=null){
            details=(diytypes[])extra.getSerializable("obj");
        }


        recyclerVIew=findViewById(R.id.rv_DIYtypes);

        recyclerVIew.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerVIew.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(recyclerVIew.getContext(),
                layoutManager.getOrientation());
        recyclerVIew.addItemDecoration(dividerItemDecoration);

        videoAdapter=new videoadapter(details);
        recyclerVIew.setAdapter(videoAdapter);
    }
}
