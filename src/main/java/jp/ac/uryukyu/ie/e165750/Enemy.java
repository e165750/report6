package jp.ac.uryukyu.ie.e165750;

/**
 * Created by e165750 on 2017/01/10.
 */

public class Enemy extends LivingThing {


    public Enemy(String name, int maximumHP, int attack) {//コンストラクタ
        super(name, maximumHP, attack);//ここでスーパークラスからの継承を受けている
    }


    @Override //オーバーライドする事によってスーパークラスから継承したメソッドに上書きすることができる
    public void attack(LivingThing opponent) {
        int damage;

        damage = (int) (Math.random() * attack);

        if (dead == false && damage>0) {

            double d = Math.random();
            if(d < 0.2){
                damage = damage * 2;
                System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n",name, opponent.getName(), damage);

            }
            else{
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            }

        } else if(dead == false && damage==0) {

            System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n",name, opponent.getName());

        }
        opponent.wounded(damage);

    }


    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint < 0) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }

}




