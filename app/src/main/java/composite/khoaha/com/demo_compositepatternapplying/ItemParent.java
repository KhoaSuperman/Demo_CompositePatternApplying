package composite.khoaha.com.demo_compositepatternapplying;

import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HoangAnhKhoa on 12/29/15.
 */
public class ItemParent extends Item {

    String text;
    int icon;
    int dimen;

    LinearLayout rootView;

    ArrayList<Item> childs;

    public ItemParent(String text, @DrawableRes int icon, @DimenRes int dimen) {
        this.text = text;
        this.icon = icon;
        this.dimen = dimen;
        childs = new ArrayList<>();
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void setIcon(@DrawableRes int drawable) {
        this.icon = drawable;
    }

    @Override
    public void setIconSize(@DimenRes int dimen) {
        this.dimen = dimen;
    }

    @Override
    public void setRootView(LinearLayout rootView) {
        this.rootView = rootView;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public int getIcon() {
        return icon;
    }

    @Override
    public int getDimen() {
        return dimen;
    }

    @Override
    public void addChild(Item item) {
        childs.add(item);
    }

    @Override
    public void removeChild(Item item) {
        childs.remove(item);
    }

    @Override
    public View generateView() {
        for (Item item : childs) {
            LinearLayout itemTemplate = getItemLayoutTemp();
            ((TextView) itemTemplate.findViewById(R.id.tvText)).setText(item.getText());
            ((ImageView) itemTemplate.findViewById(R.id.ivIcon)).setImageResource(item.getIcon());

            //set dimen
//            float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, item.getDimen(), itemTemplate.getContext().getResources().getDisplayMetrics());
            float px = itemTemplate.getContext().getResources().getDimension(item.getDimen());
            itemTemplate.findViewById(R.id.ivIcon).getLayoutParams().width = (int) px;
            itemTemplate.findViewById(R.id.ivIcon).getLayoutParams().height = (int) px;

            rootView.addView(itemTemplate);

            item.setRootView(rootView);
            item.generateView();
        }

        return rootView;
    }

    public LinearLayout getItemLayoutTemp() {
        return (LinearLayout) LayoutInflater.from(rootView.getContext()).inflate(R.layout.item_view, rootView, false);
    }
}
