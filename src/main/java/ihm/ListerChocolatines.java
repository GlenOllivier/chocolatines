package ihm;

import bean.Chocolatine;
import util.Constantes;

import javax.persistence.EntityManager;
import java.util.List;

public class ListerChocolatines implements MenuOption {
    @Override
    public String getName() {
        return "Lister les chocolatines";
    }

    @Override
    public void run() {

        Constantes.CHOCOLATINE_SERVICE.getChocolatines().forEach(System.out::println);
    }
}
