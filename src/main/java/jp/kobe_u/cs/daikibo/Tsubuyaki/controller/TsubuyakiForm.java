package jp.kobe_u.cs.daikibo.Tsubuyaki.controller;

import lombok.Data;

@Data
public class TsubuyakiForm {
    String name; // 投稿者
    String comment; // つぶやき（省略不可）
}