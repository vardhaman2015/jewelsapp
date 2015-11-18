package com.vardhaman.jewelapp.adapter;

import java.io.InputStream;
import java.net.URL;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.vardhaman.jewelapp.R;


public class ImageAdapterSplash extends PagerAdapter {
	Context context;
	private int[] GalImages = new int[] {
			R.drawable.diamond_1,
			R.drawable.diamond_2,
			R.drawable.diamond_3,
			R.drawable.diamond_4
};
	public ImageAdapterSplash(Context context){
			this.context=context;
	}
	@Override
	public int getCount() {
		return GalImages.length;
	}
 
	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((ImageView) object);
	}
 
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ImageView imageView = new ImageView(context);
		int padding = context.getResources().getDimensionPixelSize(R.dimen.imagemargin);
		//imageView.setPadding(padding, padding, padding, padding);
		//imageView.setScaleType(ImageView.ScaleType.);
		
		imageView.setImageResource(GalImages[position]);
		/*String image = ListViewAdapter.items.get(position).getProduct_id()
				.replace(" ", "%20");
		*/
		//new LoadImage(imageView).execute("http://dakshjewellery.com/image/" + image);
	/*	new LoadImage(imageView).execute("http://dakshjewellery.com/shopfun/product.php?product_id=" + image);
		Log.d("image value",image);*/
        ((ViewPager) container).addView(imageView, 0);
        return imageView;
		
		
	}
 
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView((ImageView) object);
	}
}