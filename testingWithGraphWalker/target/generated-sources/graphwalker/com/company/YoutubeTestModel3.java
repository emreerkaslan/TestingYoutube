// Generated by GraphWalker (http://www.graphwalker.org)
package com.company;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "com/company/YoutubeTestModel1.json")
public interface YoutubeTestModel3 {

    @Vertex()
    void v_Explore();

    @Edge()
    void e_ClickBack();

    @Vertex()
    void v_SigninPage();

    @Edge()
    void e_StartByHomepage();

    @Vertex()
    void v_FeaturedPage();

    @Edge()
    void e_ClickHomepage();

    @Vertex()
    void v_Start();

    @Edge()
    void e_ClickExplore();

    @Vertex()
    void v_Homepage();

    @Edge()
    void e_ClickFeatured();

    @Edge()
    void e_ClickSignin();
}