package com.sutjjang;

import com.beust.jcommander.Parameter;

public class qwer{
    @Parameter(names = {"--help","-h"}, description = "ㅎㅎㅎ...")
    private String help;
    
    public String Help(){
        return help==null? "에반데...": this.help;
    }
}