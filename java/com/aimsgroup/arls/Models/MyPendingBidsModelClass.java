package com.aimsgroup.arls.Models;

import com.aimsgroup.arls.R;

public class MyPendingBidsModelClass {
    int image;
    String name;
    String time;
    int rate;
    String additional;
    String buttonTag;


    public MyPendingBidsModelClass(int image, String name, String time, int rate, String additional, String buttonTag) {
        this.image = image;
        this.name = name;
        this.time = time;
        this.rate = rate;
        this.additional = additional;
        this.buttonTag = buttonTag;
    }



    public int getImage() {
        return R.drawable.profile;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public int getRate() {
        return rate;
    }

    public String getAdditional() {
        return additional;
    }

    public String getButtonTag() {
        return buttonTag;
    }



}
