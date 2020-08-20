package com.example.administrator.layoutinflaterprojet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import  android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    /*上述代码中的protected void onCreate()方法其实是覆写了基类（Activity类）的onCreate方法，super.onCreate()是在调用基类中的onCreate方法。而在子类的onCreate方法中，不能直接调用onCreate(),因为这样做会产生递归，为了解决这一问题，java用super关键字表示超类的意思，当前类就是从超类继承而来的

    savedInstanceState是保存当前Activity的状态信息，如果一个非running的Activity因为资源紧张而被系统销毁，当再次启动这个Activity时，可以通过这个保存下来的状态实例，即通过saveInstanceState获取之前的信息，然后使用这些信息，让用户感觉和之前的界面一模一样，提升用户体验。*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);// super 是指父类 onCreate Actitivy的入口函数。savedInstanceState保存上一次退出
        setContentView(R.layout.activity_main);
        //获得LayoutInflater 对象
        final LayoutInflater inflater = LayoutInflater.from(this);
        //获得外部容器对象
        //RelativeLayout相对布局可以理解为某一个元素为参照物，来定位的布局方式。
         final RelativeLayout rly = (RelativeLayout) findViewById(R.id.RelativeLayout1);

        Button button =(Button) findViewById(R.id.btnLoad);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //加载要添加的布局对象.获得Inflater对象,同时加载被添加的布局的xml,通过findViewById找到最外层的根节点
                LinearLayout ly = (LinearLayout) inflater.inflate(
                        R.layout.inflate, null, false).findViewById(
                        R.id.ly_inflate);
                //设置加载布局的大小与位置为这个容器设置大小与位置信息:
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.addRule(RelativeLayout.CENTER_IN_PARENT);
               // 添加到外层容器中:
                rly.addView(ly,lp);

            }
        });

    }
}
