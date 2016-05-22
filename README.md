# SemiCircleView
圆弧进度展示控件
# Demo
![](https://github.com/EoniJJ/SemiCircleView/blob/master/device-2016-05-19-212355.png)
![](https://github.com/EoniJJ/SemiCircleView/blob/master/show.gif)
# How to use ?
in `activity_main.xml`
```xml
    <com.zzj.library.SemiCircleView
        android:id="@+id/test"
        app:bottomText="好友平均步数3323步"
        app:centerText="4278"
        app:topText="截至18:06已走"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
```
if you want to start animation,just in `MainActivity.java` (if your mCenterText is not only number,that it can't change)
```java
    SemiCircleView semiCircleView = (SemiCircleView) findViewById(R.id.test);
    semiCircleView.setAnimation(true);
```

# Attribute

### There are several attributes you can set:
##### Text:
+  topText(顶部文字)
+  centerText(中间文字)
+  bottomText(底部文字)

##### TextSize:
+ topTextSize(顶部文字大小)
+ centerTextSize(中间文字大小)
+ bottomTextSize(底部文字大小)

##### Color:
+ TopTextColor(顶部文字颜色)
+ centerTextColor(中间文字颜色)
+ bottomTextColor(底部文字颜色)
+ circleBackground(圆环背景色)
+ progressColor(进度条颜色)

##### Others:
+ startAngle(开始角度，以3点钟为0°)
+ seepAngle(扫过的角度)
+ progressValue(进度条百分比)
+ ringWidth(圆弧的宽度)

for example, `in layout_main.xml`

    <com.zzj.library.SemiCircleView
        android:id="@+id/test"
        app:bottomText="好友平均步数3323步"
        app:centerText="4278"
        app:topText="截至18:06已走"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:progressValue="50"/>

and also you can in `MainActivity.java`

    semiCircleView.setmProgressValue(50);

# Contacts
Email:397336190@qq.com
