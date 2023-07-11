package com.aimsgroup.arls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.aimsgroup.arls.Adapters.RecyclerViewAdapter;
import com.aimsgroup.arls.Models.GetBIdsDataModel;
import com.aimsgroup.arls.Models.MyPendingBidsModelClass;
import com.aimsgroup.arls.Models.RecyclerViewModelClass;
import com.aimsgroup.arls.database.BidsDatabase;


import java.util.ArrayList;

public class MyPendingBids extends AppCompatActivity {
    ArrayList<RecyclerViewModelClass> recyclerViewModelClasses = new ArrayList<>();
    String username;
    BidsDatabase myBids = new BidsDatabase(this);
    ArrayList<MyPendingBidsModelClass> myPendingBidsModelClasses = new ArrayList<>();
    public int[] Image;
    public String[] Name;
    public String[] Time;
    public int[] Rate;
    public String[] Additional;
    public String[] ButtonTag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pending_bids);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        setRecyclerViewModelClasses();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, recyclerViewModelClasses);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    int[] userImage = {
            R.drawable.pet_white1,
            R.drawable.pet_green,
            R.drawable.mix_pp_loose,
            R.drawable.tokri_loose,
            R.drawable.color_hd_loose,
            R.drawable.white_hd_loose,
            R.drawable.film_loose,
            R.drawable.occ_a_loose,
            R.drawable.occ_b_loose,
            R.drawable.paper_loose,
            R.drawable.metal_loose,
            R.drawable.a_can_loose,
            R.drawable.a_pot,
            R.drawable.e_waste,
            R.drawable.pc_bottle
    };

    private void setRecyclerViewModelClasses(){
        ArrayList<GetBIdsDataModel> getBIdsDataModels = myBids.readCourses();
        int image = R.drawable.profile;
        int size = getBIdsDataModels.size();
        Image = new int[size];
        Name = new String[size];
        Time = new String[size];
        Rate = new int[size];
        Additional = new String[size];
        ButtonTag = new String[size];
        for (int i=0; i < getBIdsDataModels.size(); i++) {

            Log.d("listData", "Got DataFRom SQLITE " +getBIdsDataModels.get(i).getUsername()+" "
                    +getBIdsDataModels.get(i).getName()+" "
                    +getBIdsDataModels.get(i).getTag()+" "
                    +getBIdsDataModels.get(i).getTime()+" "
                    +getBIdsDataModels.get(i).getAmount()+" "
                    +getBIdsDataModels.get(i).getApproval()+" ");

//            int image, String name, String time, int rate, String additional, String buttonTag
            Image[i]      = image;
            Name[i]       = getBIdsDataModels.get(i).getName();
            Time[i]       = getBIdsDataModels.get(i).getTime();
            Rate[i]       = getBIdsDataModels.get(i).getAmount();
            Additional[i] = getBIdsDataModels.get(i).getAdditional();
            ButtonTag[i]  = getBIdsDataModels.get(i).getTag();

            Log.d("listData", "Found Data: "+ Image[i]+" "+Name[i]+" "+Time[i]+" "+Rate[i]+" "+Additional[i]+" "+ButtonTag[i]);
            System.out.println("Found Data: "+ Image[i]+" "+Name[i]+" "+Time[i]+" "+Rate[i]+" "+Additional[i]+" "+ButtonTag[i]);
        }

        String[] userFullName = getResources().getStringArray(R.array.materials_names_array);
        String[] userFirstWordName = getResources().getStringArray(R.array.materials_names_first_word_array);
        String[] userShortcutName = getResources().getStringArray(R.array.materials_names_shortcut_array);


        for (int i = 0; i < Name.length; i++){
            recyclerViewModelClasses.add(new RecyclerViewModelClass(
                    Name[i],
                    Time[i],
                    Additional[i],
                    Image[i]
            ));
        }

    }

}