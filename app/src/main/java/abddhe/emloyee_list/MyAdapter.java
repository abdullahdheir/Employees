package abddhe.emloyee_list;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MyAdapter extends BaseAdapter implements Filterable {

        Context context;
        List<Employee> employees;
        List<Employee> copy_emp;
        public MyAdapter(List<Employee> employees, Context context){
            this.context=context;
            this.employees=employees;
            this.copy_emp=employees;


        }

        @Override
        public int getCount() {
            return employees.size();
        }

        @Override
        public Object getItem(int position) {
            return employees.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View myView=null;
            if (convertView==null) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                 myView = layoutInflater.inflate(R.layout.for_adptaer, parent, false);
                ViewHolder vh=new ViewHolder();
                 vh.emp_depart = myView.findViewById(R.id.emp_depart);
                vh.emp_name = myView.findViewById(R.id.emp_name);
                vh.emp_id = myView.findViewById(R.id.emp_id);
                vh.emp_jop = myView.findViewById(R.id.emp_jop);
                vh.image = myView.findViewById(R.id.image);
                myView.setTag(vh);
            }else{
                myView=convertView;
            }
            Employee e=employees.get(position);
            ViewHolder vh=(ViewHolder) myView.getTag();
            vh.emp_depart.setText(e.getEmp_depart());
            vh.emp_name.setText(e.getEmp_name());
            vh.emp_id.setText("ID NO : " +e.getEmp_id());
            vh.emp_jop.setText(e.getEmp_jop());
            vh.image.setImageResource(e.getImage());
            return myView;
        }

        public Filter getFilter() {

            Filter filter=new Filter() {


                FilterResults filterResults=new FilterResults();
                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {
                    List<Employee> temp=new ArrayList<Employee>();
                    for(int i=0;i<copy_emp.size();i++){
                        Employee e=copy_emp.get(i);
                        String cno=e.getEmp_id()+"";
                        String jo = e.getEmp_jop();
                        String de = e.getEmp_jop();
                        if(e.getEmp_name().toLowerCase().contains(charSequence.toString().toLowerCase())||cno.toLowerCase().contains(charSequence.toString().toLowerCase())||jo.toLowerCase().contains(charSequence.toString().toLowerCase())||de.toLowerCase().contains(charSequence.toString().toLowerCase())){
                            temp.add(e);
                        }

                    }
                    filterResults.count=temp.size();
                    filterResults.values=temp;


                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                    employees=(List<Employee>)filterResults.values;
                    notifyDataSetChanged();


                }
            };


            return filter;
        }
    class ViewHolder{
        TextView emp_depart;
        TextView emp_name;
        TextView emp_id;
        TextView emp_jop;
        ImageView image;



    }
}
