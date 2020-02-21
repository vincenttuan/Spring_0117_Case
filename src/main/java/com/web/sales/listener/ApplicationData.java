package com.web.sales.listener;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationData implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Map menus = new LinkedHashMap();
        menus.put("discount_code.jsp", new String[]{"/mvc/discount_code/input", "優惠碼"});
        menus.put("micro_market.jsp", new String[]{"/mvc/micro_market/input", "市場區域"});
        sce.getServletContext().setAttribute("menus", menus);
        
    }

}
