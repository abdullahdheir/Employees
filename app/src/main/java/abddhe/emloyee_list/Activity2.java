package abddhe.emloyee_list;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Activity2 extends AppCompatActivity {
    int images[]=new int[]{R.drawable.emp6,R.drawable.emp2,R.drawable.emp3
            ,R.drawable.emp4,R.drawable.emp5};
    String employees []= new String[]{"Abdallah","Mohammed","Ahmed","Fears","Ali"};
    String departments []= new String[]{"Engineer","Web Development","Web Development","Management","Web Development"};
    String jops []= new String[]{"Building Engineer","Full Stack Developer","Web Designer","Co-Founder","Back-End Developer"};
    String idss[]=new String[]{"10023","15456","10025","10021","10020"};
    String[][] marge ={ employees, departments,idss };
    int ids[]=new int[]{10023,15456,10025,10021,10020};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        ListView listData=findViewById(R.id.listData);



        ArrayAdapter<String> ad = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.select_dialog_multichoice);
        for(int i = 0 ; i < employees.length ; i++) {
            for(int j = 0 ; j<marge.length;j++){
                 ad.add(marge[j][i]+ "\n"+marge[j+=1][i]+ "\n"+marge[j+=1][i]);
        }
        }
        listData.setAdapter(ad);
        listData.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);


        listData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray ab =  listData.getCheckedItemPositions();
                ArrayList<String> temp = new ArrayList<String>();
                ArrayList<String> temp33 = new ArrayList<String>();
//                String size = ab.size()+"";
//                Toast.makeText(getApplicationContext(),size,Toast.LENGTH_LONG).show();
                for(int i=0;i<=employees.length;i++){

                    if (ab.get(i)) {
                        temp.add( listData.getItemAtPosition(i).toString());
                    }
                }

                Intent i = new Intent(getApplicationContext(),MainActivity.class);

                for (int k=0; k < temp.size();k++){
                    String rep = temp.get(k).replaceAll("\\D+", "");
                    temp33.add(rep);
                }
                i.putExtra("employees",temp33);
                setResult(444,i);
            }
        });
    }
}