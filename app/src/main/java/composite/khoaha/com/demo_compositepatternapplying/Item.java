package composite.khoaha.com.demo_compositepatternapplying;

import android.content.Context;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by HoangAnhKhoa on 12/29/15.
 */
public abstract class Item {

    public abstract void setText(String text);

    public abstract void setIcon(@DrawableRes int drawable);

    public abstract void setIconSize(@DimenRes int dimen);

    public abstract void setRootView(LinearLayout rootView);

    public String getText() {
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }

    public int getIcon() {
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }

    public int getDimen(){
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }

    public void addChild(Item item){
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }
    public void removeChild(Item item){
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }

    public View generateView(){
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }
}
