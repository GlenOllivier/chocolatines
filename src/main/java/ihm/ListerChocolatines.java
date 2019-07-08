package ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.ChocolatineService;


@Controller
public class ListerChocolatines implements MenuOption {
    @Autowired
    private ChocolatineService chocolatineService;

    @Override
    public String getName() {
        return "Lister les chocolatines";
    }

    @Override
    public void run() {

        chocolatineService.getChocolatines().forEach(System.out::println);
    }
}
