package sam.chatnow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GroupAcivity extends AppCompatActivity {
  //  private View groupview;
   // private ListView listView;
    // ArrayAdapter<String> arrayAdapter;
    //ArrayList<String> listofgroup=new ArrayList<>();

    DatabaseReference databaseReference;
    Set<String> set = new HashSet<>();
    ArrayList<String> listofgroup=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    String groupname;


    ArrayList<Group> groupArrayList=new ArrayList<>();
    GroupArrayAdapter groupArrayAdapter;
    Group groupobj;
    RecyclerView recyclerView;
    String groupnamevalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        setTitle("Groups");

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Groups");
     //   if(databaseReference ==){
       //     final TextView error=new TextView(GroupAcivity.this);
            //  String erroemessage=error.getText().toString();
         //   error.setText("No Groups Created");
            //erroemessage.
        //}
       // final Group[] group=new Group[]{
         //       new Group("groupname")
       // };
        recyclerView=findViewById(R.id.grouprecylerview);
  //  groupArrayAdapter=new GroupArrayAdapter(this,groupArrayList);
    //    recyclerView.setAdapter(groupArrayAdapter);

       // GroupArrayAdapter adapter=new GroupArrayAdapter(group);
       // recyclerView.setHasFixedSize(true);
       // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(adapter);
       // recyclerView.setAdapter(groupArrayAdapter);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //  ArrayList<String> stringArrayList= new ArrayList<String>();

                Iterator iterator = dataSnapshot.getChildren().iterator();
                if(iterator!=null){
                while (iterator.hasNext()) {
                  //  set.add(((DataSnapshot) iterator.next()).getKey());

             groupnamevalue=(((DataSnapshot) iterator.next()).getKey());
                    groupname= groupnamevalue;
                    groupobj=new Group(groupname);
                    System.out.println("groupnames" +groupobj);
                    groupArrayList.add(groupobj);

                //    set.add(((DataSnapshot) iterator.next()).getKey());
                   // listofgroup.clear();
                    //listofgroup.addAll(set);
                  //  arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, listofgroup);
                }
                }

               //  groupname= groupnamevalue;
                //groupobj=new Group(groupname);
                ///groupArrayList.add(groupobj);

                groupArrayAdapter=new GroupArrayAdapter(GroupAcivity.this,groupArrayList);
                recyclerView.setLayoutManager(new LinearLayoutManager(GroupAcivity.this));
                recyclerView.setAdapter(groupArrayAdapter);

                System.out.println("groupnames" +groupArrayList);
                System.out.println("groupnames" +listofgroup);
                System.out.println("groupnames" +groupname);

           //     listofgroup.clear();
             //   listofgroup.addAll(set);
              //  arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, listofgroup);
                //arrayAdapter.notifyDataSetChanged();
                // groupname = String.valueOf(set);


                //   String.valueOf(listofgroup);
                //  System.out.println("groupnames" +listofgroup);

                //listofgroup.clear();
                //listofgroup.addAll(set);
                //arrayAdapter.notifyDataSetChanged();


                // groupname= String.valueOf(stringArrayList);
                //adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    //    listView = findViewById(R.id.grouplistview);
     //   arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, listofgroup);
      //  listView.setAdapter(arrayAdapter);
        // retriveAndDisplayGroup();
    }
    }
