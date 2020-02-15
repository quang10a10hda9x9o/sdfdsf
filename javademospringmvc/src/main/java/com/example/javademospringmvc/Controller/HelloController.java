package com.example.javademospringmvc.Controller;

import com.example.javademospringmvc.Model.Hello;
import com.example.javademospringmvc.Model.Menuitem;
import com.example.javademospringmvc.Model.Platform;
import com.example.javademospringmvc.utils.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    //Tao 1 list game rong
    List<Platform> platformList = new ArrayList<>();
    List<Menuitem> lstMenu = new ArrayList<>();
    List<Platform> platforms1 = new ArrayList<>();

    //Báo hiệu cho Spring biết khi quét đến controller tự thực hiện mockData mà k cần gọi
    @PostConstruct
    public void mockDate() {
        //mock data
        platformList.add(new Platform("QuangĐẹpTrai1","gamebg/bg1.jpg",200000,100000,50));
        platformList.add(new Platform("QuangĐẹpTrai2","gamebg/bg2.jpg",400000,200000,50));
        platformList.add(new Platform("QuangĐẹpTrai3","gamebg/bg3.jpg",400000,200000,50));
        platformList.add(new Platform("QuangĐẹpTrai4","gamebg/bg4.jpg",400000,200000,50));
        platformList.add(new Platform("QuangĐẹpTrai5","gamebg/bg5.jpg",400000,200000,50));
        platformList.add(new Platform("QuangĐẹpTrai6","gamebg/bg6.jpg",400000,200000,50));
        platformList.add(new Platform("QuangĐẹpTrai7","gamebg/bg7.png",400000,200000,50));
        platformList.add(new Platform("QuangĐẹpTrai8","gamebg/bg8.jpg",400000,200000,50));
        platformList.add(new Platform("QuangĐẹpTrai9","gamebg/bg15.jpg",400000,200000,50));
        platformList.add(new Platform("QuangĐẹpTrai10","gamebg/bg16.jpg",400000,200000,50));
        platformList.add(new Platform("QuangĐẹpTrai11","gamebg/bg17.jpg",400000,200000,50));
        platformList.add(new Platform("QuangĐẹpTrai12","gamebg/bg8.jpg",400000,200000,50));

        lstMenu.add(new Menuitem("Menu1","icon/account.png"));
        lstMenu.add(new Menuitem("Menu1","icon/account.png"));
        lstMenu.add(new Menuitem("Menu1","icon/account.png"));
        lstMenu.add(new Menuitem("Menu1","icon/account.png"));
        lstMenu.add(new Menuitem("Menu1","icon/account.png"));
        lstMenu.add(new Menuitem("Menu1","icon/account.png"));
        lstMenu.add(new Menuitem("Menu1","icon/account.png"));
        lstMenu.add(new Menuitem("Menu1","icon/account.png"));

        platforms1.add(new Platform("QuangĐẹpTrai","gamebg/bg9.jpg",200000,100000,50));
        platforms1.add(new Platform("QuangĐẹpTrai","gamebg/bg10.jpg",200000,100000,50));
        platforms1.add(new Platform("QuangĐẹpTrai","gamebg/bg11.jpg",200000,100000,50));
        platforms1.add(new Platform("QuangĐẹpTrai","gamebg/bg12.jpg",200000,100000,50));
        platforms1.add(new Platform("QuangĐẹpTrai","gamebg/bg13.jpg",200000,100000,50));
        platforms1.add(new Platform("QuangĐẹpTrai","gamebg/bg14.jpg",200000,100000,50));

    }

    @RequestMapping("/home")
    public String hello(Model model,
                        @RequestParam(value = "page",defaultValue = "0")int page,
                        @RequestParam(value = "filter",defaultValue = "0")int filter) {

        //Tinh số page
        List<Platform> gameOfPage = new ArrayList<>();

        int index = page*Constant.PAGE_SIZE;
        int lengthGame = index + Constant.PAGE_SIZE > platformList.size() ?
                platformList.size() :
                index + Constant.PAGE_SIZE;
        for(int i=index ; i<lengthGame ; i++) {
            if(filter == 1) {
                Platform game = platformList.get(i);
                if(game.getNewprice() < 5000) {
                    gameOfPage.add(platformList.get(i));
                }
            }
            gameOfPage.add(platformList.get(i));
        }
        //Tinh số trang truyền cho view
        int totalPage = platformList.size() % Constant.PAGE_SIZE != 0 ?
                (platformList.size()/Constant.PAGE_SIZE + 1) :
                (platformList.size()/Constant.PAGE_SIZE);

        model.addAttribute("listgame", gameOfPage);
        model.addAttribute("listgame1",platforms1);
        model.addAttribute("listMenu",lstMenu);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("curentPage",page);

        return"home";
    }

    @RequestMapping("/detail")
    public String hello1(Model model) {
        return"detail";
    }
}
