package com.example.android.rangga_1202154227_modul5;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by ranggaardi on 3/25/2018.
 */

public class hapus_swipe extends ItemTouchHelper.SimpleCallback {
    adapter adp;
    public hapus_swipe(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);
    }

    public hapus_swipe(adapter dpter){
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT);
        this.adp = dpter;
    }
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        adp.hpsData(viewHolder.getAdapterPosition());

    }
}
