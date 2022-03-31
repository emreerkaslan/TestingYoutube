// Generated by GraphWalker (http://www.graphwalker.org)
package com.company;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "com/company/YoutubeTestModel1.json")
public interface YoutubeTestModel1 {

    @Edge()
    void e_GoLibrary();

    @Vertex()
    void v_Explore();

    @Edge()
    void e_StartbyHomepage();

    @Edge()
    void e_GoHistory();

    @Vertex()
    void v_History();

    @Edge()
    void e_GoExplore();

    @Vertex()
    void v_Subscriptions();

    @Vertex()
    void v_Library();

    @Vertex()
    void v_Start();

    @Edge()
    void e_GoSubscriptions();

    @Edge()
    void e_GoHomepage();

    @Vertex()
    void v_Homepage();
}
