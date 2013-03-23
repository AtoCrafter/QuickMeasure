package ato.quickmeasure;

import ato.quickmeasure.measure.Measure;

/**
 * プレイヤーが現在利用しているメジャーの管理をする
 */
public class MeasuresManager {

    /**
     * 現在アクティブのメジャー
     */
    private Measure measure;

    /**
     * 現在プレイヤーが有効にしているメジャーを返す
     *
     * @return 非アクティブの場合は null
     */
    public Measure getActiveMeasure() {
        return measure;
    }

    /**
     * アクティブなメジャーを指定する
     *
     * @param measure 非アクティブにする場合は null
     */
    public void setActiveMeasure(Measure measure) {
        if (this.measure != measure) {
            if (this.measure != null) {
                this.measure.stop();
            }
            this.measure = measure;
            if (this.measure != null) {
                this.measure.start();
            }
        }
    }
}
