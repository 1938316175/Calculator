package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends Activity {

	private TextView tView;
	private Button button_add;
	private Button button_subtraction;
	private Button button_multiply;
	private Button button_division;
	private Button button_delete;
	private Button button_c;
	private Button button_result;
	private Button button_point;
	private Button button_0;
	private Button button_1;
	private Button button_2;
	private Button button_3;
	private Button button_4;
	private Button button_5;
	private Button button_6;
	private Button button_7;
	private Button button_8;
	private Button button_9;
	private String result="";
	//储存运算符的位置
	private boolean flag[] = new boolean [100];
	int k = 0;
	private int temp = 0, count = 0;
	private double number[] = new double[100];
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tView = (TextView)findViewById(R.id.tv);
        button_0 = (Button)findViewById(R.id.button_0);
        button_0.setOnClickListener(listener);
        button_1 = (Button)findViewById(R.id.button_1);
        button_1.setOnClickListener(listener);
        button_2 = (Button)findViewById(R.id.button_2);
        button_2.setOnClickListener(listener);
        button_3 = (Button)findViewById(R.id.button_3);
        button_3.setOnClickListener(listener);
        button_4 = (Button)findViewById(R.id.button_4);
        button_4.setOnClickListener(listener);
        button_5 = (Button)findViewById(R.id.button_5);
        button_5.setOnClickListener(listener);
        button_6 = (Button)findViewById(R.id.button_6);
        button_6.setOnClickListener(listener);
        button_7 = (Button)findViewById(R.id.button_7);
        button_7.setOnClickListener(listener);
        button_8 = (Button)findViewById(R.id.button_8);
        button_8.setOnClickListener(listener);
        button_9 = (Button)findViewById(R.id.button_9);
        button_9.setOnClickListener(listener);
        button_point = (Button)findViewById(R.id.button_point);
        button_point.setOnClickListener(listener);
        button_add = (Button)findViewById(R.id.button_add);
        button_add.setOnClickListener(listener);
        button_subtraction = (Button)findViewById(R.id.button_subtraction);
        button_subtraction.setOnClickListener(listener);
        button_multiply = (Button)findViewById(R.id.button_multiply);
        button_multiply.setOnClickListener(listener);
        button_division = (Button)findViewById(R.id.button_division);
        button_division.setOnClickListener(listener);
        button_delete = (Button)findViewById(R.id.button_delete);
        button_delete.setOnClickListener(listener);
        button_c = (Button)findViewById(R.id.button_c);
        button_c.setOnClickListener(listener);
        button_result = (Button)findViewById(R.id.button_result);
        button_result.setOnClickListener(listener);
        
    //    Log.d("wangbin", result);
    }
	

    
    OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			//运算法则
			case R.id.button_add:
				result = result + "+";          //显示出来
				tView.setText(result);
				break;
			case R.id.button_subtraction:
				result = result + "-";
				tView.setText(result);
				break;
			case R.id.button_multiply:
				result = result + "*";
				tView.setText(result);
				break;
			case R.id.button_division:
				result = result + "/";
				tView.setText(result);
				break;
			case R.id.button_c:               //功能：清屏，将字符串归零并将标记的数组全部初始化
				result = ""; 
				tView.setText("0");
				break;
			case R.id.button_delete:          //功能：删除最后一个字符并将考虑标志数组是否变化
				//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				if(result.length()<=1){
					result = "";
					tView.setText("0");
				}else{
					result=result.substring(0, result.length()-1);
					tView.setText(result);
				}
				break;
			case R.id.button_result:         //功能：算出结果
				/* 
				 * 有待优化！！！（可在子线程中实现，现在就直接在这里计算了）！！！！！！！！！！！！！！
				 */
				try {
					result = result + "=";
					Log.d("wangbin", result);
					Calculate calculate = new Calculate(result);
					tView.setText(calculate.getResult());
					
					//按下“=”之后将结果清零
					result="";
				} catch (Exception e) {
					tView.setText("计算式子逻辑出错！");
				}
				
				break;
				
			//数字部分
			case R.id.button_0:
				if(result==""){ //The first number can't click 0
					result = "";
				}else {
					result = result + "0";
					tView.setText(result);
				}
				break;
			case R.id.button_1:
				result = result + "1";
				tView.setText(result);
				break;
			case R.id.button_2:
				result = result + "2";
				tView.setText(result);
				break;
			case R.id.button_3:
				result = result + "3";
				tView.setText(result);
				break;
			case R.id.button_4:
				result = result + "4";
				tView.setText(result);
				break;
			case R.id.button_5:
				result = result + "5";
				tView.setText(result);
				break;
			case R.id.button_6:
				result = result + "6";
				tView.setText(result);
				break;
			case R.id.button_7:
				result = result + "7";
				tView.setText(result);
				break;
			case R.id.button_8:
				result = result + "8";
				tView.setText(result);
				break;
			case R.id.button_9:
				result = result + "9";
				tView.setText(result);
				break;
			//小数点
			case R.id.button_point:
				result = result + ".";
				tView.setText(result);
				break;
			}
			
		}
	};

}
