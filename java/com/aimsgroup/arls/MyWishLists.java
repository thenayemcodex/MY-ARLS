package com.aimsgroup.arls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aimsgroup.arls.database.DBHelper;

public class MyWishLists extends AppCompatActivity {
    String username;
    LinearLayout wp, gp, mpp, ppt, chd, whd, fm, oca, ocb, pr, sl ,acn, apt, ew, pc;
    TextView wp_desc, gp_desc, mpp_desc, ppt_desc, chd_desc, whd_desc, fm_desc, oca_desc, ocb_desc, pr_desc, sl_desc, acn_desc, apt_desc, ew_desc, pc_desc;
    String[] tagList = {"wp", "gp", "mpp", "ppt", "chd", "whd", "fm", "oca", "ocb", "pr", "sl", "acn", "apt", "ew", "pc"};
    DBHelper myDB = new DBHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wish_lists);
//        Bundle bundle = getIntent().getExtras();
//
//        if (bundle != null) {
//            username = bundle.getString("username");
//        }
        Toast.makeText(this, username, Toast.LENGTH_SHORT).show();
        wp  =  findViewById(R.id.wp);
        gp  =  findViewById(R.id.gp);
        mpp =  findViewById(R.id.mpp);
        ppt =  findViewById(R.id.ppt);
        chd =  findViewById(R.id.chd);
        whd =  findViewById(R.id.whd);
        fm  =  findViewById(R.id.fm);
        oca =  findViewById(R.id.oca);
        ocb =  findViewById(R.id.ocb);
        pr  =  findViewById(R.id.pr);
        acn =  findViewById(R.id.acn);
        apt =  findViewById(R.id.apt);
        ew  =  findViewById(R.id.ew);
        pc  =  findViewById(R.id.pc);
        sl  =  findViewById(R.id.sl);


        wp_desc  =  findViewById(R.id.wp_desc);
        gp_desc  =  findViewById(R.id.gp_desc);
        mpp_desc =  findViewById(R.id.mpp_desc);
        ppt_desc =  findViewById(R.id.ppt_desc);
        chd_desc =  findViewById(R.id.chd_desc);
        whd_desc =  findViewById(R.id.whd_desc);
        fm_desc  =  findViewById(R.id.fm_desc);
        oca_desc =  findViewById(R.id.oca_desc);
        ocb_desc =  findViewById(R.id.ocb_desc);
        pr_desc  =  findViewById(R.id.pr_desc);
        sl_desc  =  findViewById(R.id.sl_desc);
        acn_desc =  findViewById(R.id.acn_desc);
        apt_desc =  findViewById(R.id.apt_desc);
        ew_desc  =  findViewById(R.id.ew_desc);
        pc_desc  =  findViewById(R.id.pc_desc);
        for (String getTag : tagList) {
            boolean result = myDB.checkCartData(getTag, username);
            if(result){
                switch (getTag) {
                    case "wp":
                        String time = myDB.getCartTime("wp", username);
                        if (time.length() > 0) {
                            wp_desc.setText(time);
                            wp.setVisibility(View.VISIBLE);
                        }
                        break;
                    case "gp":
                        gp.setVisibility(View.VISIBLE);
                        break;
                    case "mpp":
                        mpp.setVisibility(View.VISIBLE);
                        break;
                    case "ppt":
                        ppt.setVisibility(View.VISIBLE);
                        break;
                    case "chd":
                        chd.setVisibility(View.VISIBLE);
                        break;
                    case "whd":
                        whd.setVisibility(View.VISIBLE);
                        break;
                    case "fm":
                        fm.setVisibility(View.VISIBLE);
                        break;
                    case "oca":
                        oca.setVisibility(View.VISIBLE);
                        break;
                    case "ocb":
                        ocb.setVisibility(View.VISIBLE);
                        break;
                    case "pr":
                        pr.setVisibility(View.VISIBLE);
                        break;
                    case "sl":
                        sl.setVisibility(View.VISIBLE);
                        break;
                    case "acn":
                        acn.setVisibility(View.VISIBLE);
                        break;
                    case "apt":
                        apt.setVisibility(View.VISIBLE);
                        break;
                    case "ew":
                        ew.setVisibility(View.VISIBLE);
                        break;
                    case "pc":
                        pc.setVisibility(View.VISIBLE);
                        break;
                    default:
                        Toast.makeText(this, "Error occurred !", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        }

    }








    public void removeFromCart(View view) {
        wp  =  findViewById(R.id.wp);
        gp  =  findViewById(R.id.gp);
        mpp =  findViewById(R.id.mpp);
        ppt =  findViewById(R.id.ppt);
        chd =  findViewById(R.id.chd);
        whd =  findViewById(R.id.whd);
        fm  =  findViewById(R.id.fm);
        oca =  findViewById(R.id.oca);
        ocb =  findViewById(R.id.ocb);
        pr  =  findViewById(R.id.pr);
        sl  =  findViewById(R.id.sl);
        acn =  findViewById(R.id.acn);
        apt =  findViewById(R.id.apt);
        ew  =  findViewById(R.id.ew);
        pc  =  findViewById(R.id.pc);


        ImageView seeButton = (ImageView) view;
        String getRemoveButtonTag = seeButton.getTag().toString();
        switch (getRemoveButtonTag) {
            case "wp": {
                boolean result = myDB.deleteCartData("wp", username);
                if (result) {
                    Toast.makeText(this, "White pet removed", Toast.LENGTH_SHORT).show();
                    wp.setVisibility(View.GONE);
                } else {
                    Toast.makeText(this, "Failed to removed", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case "gp": {
                boolean result = myDB.deleteCartData("gp", username);
                if (result) {
                    Toast.makeText(this, "Green pet removed", Toast.LENGTH_SHORT).show();
                    gp.setVisibility(View.GONE);
                } else {
                    Toast.makeText(this, "Failed to removed", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case "mpp": {
                boolean result = myDB.deleteCartData("mpp", username);
                if (result) {
                    Toast.makeText(this, "Mix PP removed", Toast.LENGTH_SHORT).show();
                    mpp.setVisibility(View.GONE);
                } else {
                    Toast.makeText(this, "Failed to removed", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case "ppt": {
                boolean result = myDB.deleteCartData("ppt", username);
                if (result) {
                    Toast.makeText(this, "PP Tokri removed", Toast.LENGTH_SHORT).show();
                    ppt.setVisibility(View.GONE);
                } else {
                    Toast.makeText(this, "Failed to removed", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case "chd": {
                boolean result = myDB.deleteCartData("chd", username);
                if (result) {
                    Toast.makeText(this, "Color HD removed", Toast.LENGTH_SHORT).show();
                    chd.setVisibility(View.GONE);
                } else {
                    Toast.makeText(this, "Failed to removed", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case "whd": {
                boolean result = myDB.deleteCartData("whd", username);
                if (result) {
                    Toast.makeText(this, "White HD removed", Toast.LENGTH_SHORT).show();
                    whd.setVisibility(View.GONE);
                } else {
                    Toast.makeText(this, "Failed to removed", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case "fm": {
                boolean result = myDB.deleteCartData("fm", username);
                if (result) {
                    Toast.makeText(this, "Film removed", Toast.LENGTH_SHORT).show();
                    fm.setVisibility(View.GONE);
                } else {
                    Toast.makeText(this, "Failed to removed", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case "oca": {
                boolean result = myDB.deleteCartData("oca", username);
                if (result) {
                    Toast.makeText(this, "OCC A Grade removed", Toast.LENGTH_SHORT).show();
                    oca.setVisibility(View.GONE);
                } else {
                    Toast.makeText(this, "Failed to removed", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case "ocb": {
                boolean result = myDB.deleteCartData("ocb", username);
                if (result) {
                    Toast.makeText(this, "OCC B Grade removed", Toast.LENGTH_SHORT).show();
                    ocb.setVisibility(View.GONE);
                } else {
                    Toast.makeText(this, "Failed to removed", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case "pr": {
                boolean result = myDB.deleteCartData("pr", username);
                if (result) {
                    Toast.makeText(this, "Mix Paper removed", Toast.LENGTH_SHORT).show();
                    pr.setVisibility(View.GONE);
                } else {
                    Toast.makeText(this, "Failed to removed", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case "sl": {
                boolean result = myDB.deleteCartData("sl", username);
                if (result) {
                    Toast.makeText(this, "Metal Loose removed", Toast.LENGTH_SHORT).show();
                    sl.setVisibility(View.GONE);
                } else {
                    Toast.makeText(this, "Failed to removed", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case "acn": {
                boolean result = myDB.deleteCartData("acn", username);
                if (result) {
                    Toast.makeText(this, "Aluminium Can removed", Toast.LENGTH_SHORT).show();
                    acn.setVisibility(View.GONE);
                } else {
                    Toast.makeText(this, "Failed to removed", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case "apt": {
                boolean result = myDB.deleteCartData("apt", username);
                if (result) {
                    Toast.makeText(this, "Aluminium Pot removed", Toast.LENGTH_SHORT).show();
                    apt.setVisibility(View.GONE);
                } else {
                    Toast.makeText(this, "Failed to removed", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case "ew": {
                boolean result = myDB.deleteCartData("ew", username);
                if (result) {
                    Toast.makeText(this, "Electrical Waste removed", Toast.LENGTH_SHORT).show();
                    ew.setVisibility(View.GONE);
                } else {
                    Toast.makeText(this, "Failed to removed", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case "pc": {
                boolean result = myDB.deleteCartData("pc", username);
                if (result) {
                    Toast.makeText(this, "PC Bottle removed", Toast.LENGTH_SHORT).show();
                    pc.setVisibility(View.GONE);
                } else {
                    Toast.makeText(this, "Failed to removed", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            default:
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
                break;
        }


    }
}