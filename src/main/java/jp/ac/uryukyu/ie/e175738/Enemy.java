package jp.ac.uryukyu.ie.e175738;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy extends LivingThing{


    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        super(name,maximumHP,attack);

    }

    @Override
    public void attack(LivingThing opponent) {
        
        int damage = (int) (Math.random() * getAttack());
        int kakusin = (int) (Math.random() * 10 + 1);
        if (!isDead()) {

            if (kakusin <= 3) {
                System.out.printf("%sの攻撃！痛恨の一撃！！%Sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage * 2);
                opponent.wounded(damage * 2);
            } else if (damage == 0) {
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
            } else {
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                opponent.wounded(damage);
            }

        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        super.wounded(damage);
        setHitPoint(getHitPoint() - damage);
        if( getHitPoint() <= 0 ) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }

}