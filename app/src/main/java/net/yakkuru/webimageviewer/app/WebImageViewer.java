package net.yakkuru.webimageviewer.app;

import android.app.Activity;
import android.os.Bundle;
import java.io.InputStream;
import java.net.URL;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;



public class WebImageViewer extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //StrictModeを設定 penaltyDeathを取り除く
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
        setContentView(R.layout.main);

        //ImageViewを取得
        ImageView oImg = (ImageView) findViewById(R.id.WebImage);
        //layout
        RelativeLayout rLayout = (RelativeLayout) findViewById(R.id.rLayout);

        URL url;
        InputStream istream;
        try {
            //画像のURLを直うち
            url = new URL("http://i.gyazo.com/aa34f9f8ea6367430d41e930e204529b.png");
            //インプットストリームで画像を読み込む
            istream = url.openStream();
            //読み込んだファイルをビットマップに変換
            Bitmap oBmp = BitmapFactory.decodeStream(istream);
            //ビットマップをImageViewに設定
            oImg.setImageBitmap(oBmp);
            //インプットストリームを閉じる
            istream.close();
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

    }
}