package ato.quickmeasure.measure;

/**
 * 計測を行う
 */
public abstract class Measure {

    /**
     * 計測結果を文字列で返す
     *
     * @return 計測が無効であれば null
     */
    public abstract String getText();

    /**
     * 開始処理
     */
    public abstract void start();

    /**
     * 終了処理
     */
    public abstract void stop();
}
