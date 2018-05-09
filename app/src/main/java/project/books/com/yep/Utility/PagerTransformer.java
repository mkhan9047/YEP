package project.books.com.yep.Utility;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Mujahid on 4/26/2018.
 */

public class PagerTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        if(position==0){
            ViewCompat.setScaleX(page, 1);
            ViewCompat.setScaleY(page, 1);
        }
        else{
            float mScale = 0.5f;
            ViewCompat.setScaleX(page, mScale);
            ViewCompat.setScaleY(page, mScale);
        }
    }
}
