package com.example.timetable;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.timetable.Category.categoryAdapter;
import com.example.timetable.Category.categoryObject;
import com.example.timetable.databinding.FragmentFirstBinding;
import com.example.timetable.databinding.FragmentSecondBinding;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

    public class SecondFragment extends Fragment {

        private FragmentSecondBinding binding;
        private categoryAdapter adapterCate ;
        private ArrayList<String> list_lich;
        private ArrayAdapter<String> items;
        int b,c;
        @Override
        public View onCreateView(
                LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState
        ) {

            binding = FragmentSecondBinding.inflate(inflater, container, false);
            return binding.getRoot();

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            list_lich = new ArrayList<>();
            items = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,list_lich);

            adapterCate = new categoryAdapter(getContext(),R.layout.items_selected,getListCategory());
            binding.spnCategory.setAdapter(adapterCate);
            binding.spnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getContext(), adapterCate.getItem(i).getName(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getContext(), ""+i, Toast.LENGTH_SHORT).show();
                    switch (i){
                        case 0:
                            items.notifyDataSetChanged();
                            list_lich.clear();
                            for (int j =0; j<=6;j++){
                                String today = LocalDateTime.now().plusDays(j).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                list_lich.add(today);
                                binding.lvLich.setAdapter(items);

                            }
                            break;
                        case 1:
                            items.notifyDataSetChanged();
                            list_lich.clear();
                            for (int j =0; j<=13;j++){
                                String today = LocalDateTime.now().plusDays(j).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                list_lich.add(today);
                                binding.lvLich.setAdapter(items);
                            }
                            break;
                        case 2:
                            items.notifyDataSetChanged();
                            list_lich.clear();
                            for (int j =0; j<=20;j++){
                                String today = LocalDateTime.now().plusDays(j).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                list_lich.add(today);
                                binding.lvLich.setAdapter(items);
                            }
                            break;
                        case 3:
                            items.notifyDataSetChanged();
                            list_lich.clear();
                            for (int j =0; j<=27;j++){
                                String today = LocalDateTime.now().plusDays(j).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                list_lich.add(today);
                                binding.lvLich.setAdapter(items);
                            }
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            String today = LocalDateTime.now().plusDays(0).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String tomorrow = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

            binding.btnTime.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View view) {
                    String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                    String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

                    binding.txtCurrentDate.setText(currentDate);
                    binding.txtCurrentTime.setText(currentTime);
                    binding.txtToday.setText(today);
                    binding.txtTomorrow.setText(tomorrow);

                }
            });
            binding.btnType1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    View layout_dialog = LayoutInflater.from(getContext()).inflate(R.layout.activity_selecttime_type1,null);
                    builder.setView(layout_dialog);

                    TimePicker tp_type1 =layout_dialog.findViewById(R.id.simpleTimePicker1);
                    TextView tv_time = layout_dialog.findViewById(R.id.tv_time);

                    ;
                    ;
                    tv_time.setText(""+tp_type1.getHour()+" : "+tp_type1.getMinute());

                    tp_type1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                        @Override
                        public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                            tv_time.setText(""+i+" : "+i1);
                        }
                    });

                    builder.setPositiveButton("Đặt", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(),""+tp_type1.getHour()+" : "+tp_type1.getMinute(),Toast.LENGTH_SHORT).show();
                        }
                    })
                            .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    builder.create().show();
                    builder.setCancelable(false);
                }
            });
            binding.btnType2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    View layout_dialog = LayoutInflater.from(getContext()).inflate(R.layout.activity_selecttime_type2,null);
                    builder.setView(layout_dialog);

                    TimePicker tp_type2 =layout_dialog.findViewById(R.id.simpleTimePicker);
                    tp_type2.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                        @Override
                        public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                        }
                    });
                    builder.setPositiveButton("Đặt", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(),""+tp_type2.getHour()+" : "+tp_type2.getMinute(),Toast.LENGTH_SHORT).show();
                        }
                    })
                            .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    builder.create().show();
                    builder.setCancelable(false);

                }
            });
        }

        private List<categoryObject> getListCategory() {
            List<categoryObject> list = new ArrayList<>();
            list.add(new categoryObject("1 Tuần"));
            list.add(new categoryObject("2 Tuần"));
            list.add(new categoryObject("3 Tuần"));
            list.add(new categoryObject("4 Tuần"));
            return list;
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            binding = null;
        }

    }