package farmerthanos.mea;

import mindustry.gen.Building;
import mindustry.gen.Building.*;
import mindustry.gen.Groups;

import static mindustry.Vars.*;


public class Calls {
    public void ohno(){
        //I thank megacatswoop#7269 for this
        for (Building build : Groups.build) {
            Groups.bullet.intersect(build.x - (build.block().size / 2) - 10 * 8,
                    build.y - (build.block().size / 2) - 10 * 8,
                    10 * 8, 10 * 8, bullet -> {
                if (bullet.team != build.team) {
                    Announcements.BaseUnderAttack.play();
                }
            });
            break;
        }
    }
}
