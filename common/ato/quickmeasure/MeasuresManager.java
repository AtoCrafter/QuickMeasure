package ato.quickmeasure;

import ato.quickmeasure.measure.Measure;

import java.util.ArrayList;
import java.util.List;

/**
 * プレイヤーが現在利用しているメジャーの管理をする
 */
public class MeasuresManager {

    /**
     * 現在アクティブのメジャー
     */
    private List<Measure> measures = new ArrayList<Measure>();

    /**
     * アクティブなメジャーを追加
     */
    public void addMeasure(Measure measure) {
        measures.add(measure);
    }

    /**
     * アクティブなメジャーの実行、待機を切り替える
     */
    public void toggleRunning() {
        for (Measure m : measures) {
            if (m.isRunning()) {
                m.stop();
            } else {
                m.start();
            }
        }
    }

    /**
     * メジャーの結果の文字列を返す
     */
    public String getMeasureText() {
        String separator = " / ";
        String ret = "";
        for (Measure m : measures) {
            String text = m.getText();
            if (text != null && text != "") {
                ret += separator + m.getText();
            }
        }
        if (ret.length() > 3) {
            return ret.substring(3);
        } else {
            return null;
        }
    }
}
