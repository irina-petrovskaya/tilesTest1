package com.mytests.springmvc.tiles.tilesTest1.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 8/1/2016.
 * Project: tilesTest1
 * *******************************
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mytests.springmvc.tiles.tilesTest1.controllers")
public class MyWebConfig extends WebMvcConfigurerAdapter {

    private static final String[] TILES_DEFINITIONS1 = new String[]{"/WEB-INF/views/tiles/tiles1.xml", "/WEB-INF/views/tiles/tiles2.xml", "/WEB-INF/views/tiles/tiles3.xml"};
  private static final String TILES_DEFINITIONS = "/WEB-INF/views/**/tiles*.xml";

    /**
     * Configure ResourceHandlers
     */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    /**
     * Configure TilesConfigurer
     */
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        //tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/views/tiles/tiles1.xml", "/WEB-INF/views/tiles/tiles2.xml", "/WEB-INF/views/tiles/tiles3.xml"});   // doesn't work
        //tilesConfigurer.setDefinitions(new String("/WEB-INF/views/tiles/common.xml"));   // doesn't work
        //tilesConfigurer.setDefinitions("/WEB-INF/views/tiles/common.xml");   // works
        //tilesConfigurer.setDefinitions(TILES_DEFINITIONS); // works
        //tilesConfigurer.setDefinitions(TILES_DEFINITIONS1); // doesn't work
        tilesConfigurer.setDefinitions("/WEB-INF/views/tiles/tiles1.xml", "/WEB-INF/views/tiles/tiles2.xml", "/WEB-INF/views/tiles/tiles3.xml"); // works
       // tilesConfigurer.setDefinitions("/WEB-INF/views/**/tiles**.xml"); // works
        /*// works but should not:
        tilesConfigurer.setDefinitions("/WEB-INF/views/tiles/tiles1.xml");
        tilesConfigurer.setDefinitions("/WEB-INF/views/tiles/tiles2.xml");
        tilesConfigurer.setDefinitions("/WEB-INF/views/tiles/tiles3.xml");*/
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    /**
     * Configure ViewResolvers
     */
    // works:
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.tiles();
    }


    /*// works:
    @Bean
    public TilesViewResolver tilesViewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        return tilesViewResolver;
    }*/

    /*
    @Override
    // doesn't work:
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);

    }*/


}


