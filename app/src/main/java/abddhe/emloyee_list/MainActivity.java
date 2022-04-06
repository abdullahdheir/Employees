package abddhe.emloyee_list;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    int images[]=new int[]{R.drawable.emp6,R.drawable.emp2,R.drawable.emp3
            ,R.drawable.emp4,R.drawable.emp5};
    String employees []= new String[]{"Abdallah","Mohammed","Ahmed","Fears","Ali"};
    String departments []= new String[]{"Engineer","Web Development","Web Development","Management","Web Development"};
    String jops []= new String[]{"Building Engineer","Full Stack Developer","Web Designer","Co-Founder","Back-End Developer"};
    int ids[]=new int[]{10023,15456,10025,10021,10020};
    MyAdapter ad;
    List<Employee> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = findViewById(R.id.listView);
        list = new ArrayList<Employee>();
        SearchView se = findViewById(R.id.search);
        Button add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Activity2.class);
                startActivityForResult(i, 333);
            }
        });

        for (int i = 0; i < images.length; i++) {
            Employee e = new Employee();
            e.setEmp_id(ids[i]);
            e.setImage(images[i]);
            e.setEmp_name(employees[i]);
            e.setEmp_depart(departments[i]);
            e.setEmp_jop(jops[i]);
            list.add(e);
        }

        ad = new MyAdapter(list, this);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Employee e = (Employee) lv.getItemAtPosition(position);
//                list.remove(e);
                ad.notifyDataSetChanged();
                // Toast.makeText(getApplicationContext(),c.getId()+" "+c.getType(),Toast.LENGTH_LONG).show();
            }
        });
        se.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ad.getFilter().filter(s);
                return false;
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==333 && resultCode==444){
            ArrayList<String> datacars=data.getStringArrayListExtra("employees");
            for(int i=0;i<datacars.size();i++){
                Employee e=new Employee();
                Integer a = Integer.parseInt(datacars.get(i));
        for(int k = 0 ; k<employees.length; k++) {
            if (a == ids[k]) {
                e.setEmp_name(employees[k]);
                e.setEmp_depart(departments[k]);
                e.setEmp_jop(jops[k]);
                e.setEmp_id(a);
                e.setImage(images[k]);
            }
        }
                list.add(e);
            }
            ad.notifyDataSetChanged();

        }

    }
}
