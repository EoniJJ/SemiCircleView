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
if you want to start animation,just in `MainActivity.java`
```java
    SemiCircleView semiCircleView = (SemiCircleView) findViewById(R.id.test);
```
and override `onResume()`
```java
 @Override
    protected void onResume() {
        super.onResume();
        new Thread(semiCircleView).start();
    }
```
# Attribute

### There are several attributes you can set:
##### Text:
+  topText
+  centerText
+  bottomText

##### TextSize:
+ topTextSize
+ centerTextSize
+ bottomTextSize

##### Color:
+ TopTextColor
+ centerTextColor
+ bottomTextColor
+ circleBackground
+ progressColor

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
