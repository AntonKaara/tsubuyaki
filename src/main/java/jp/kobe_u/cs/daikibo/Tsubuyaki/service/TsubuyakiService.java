package jp.kobe_u.cs.daikibo.Tsubuyaki.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobe_u.cs.daikibo.Tsubuyaki.entity.Tsubuyaki;
import jp.kobe_u.cs.daikibo.Tsubuyaki.repository.TsubuyakiRepository;

@Service
public class TsubuyakiService {
    @Autowired
    TsubuyakiRepository repo; // レポジトリ
    // つぶやきを投稿

    public Tsubuyaki postTsubuyaki(Tsubuyaki t) {
        // 名前がない場合の業務ロジック
        String name = t.getName();
        if (name == null || name.length() == 0) {
            t.setName("名無しさん");
        }
        t.setCreatedAt(new Date()); // 作成日時をセット
        return repo.save(t); // セーブしたオブジェクトを返却
    }

    // 全つぶやきを取得
    public List<Tsubuyaki> getAllTsubuyaki() {
        Iterable<Tsubuyaki> found = repo.findAll();
        ArrayList<Tsubuyaki> list = new ArrayList<>();
        found.forEach(list::add);
        return list;
    }

    public List<Tsubuyaki> findTsubuyaki(String keyword) {
        Iterable<Tsubuyaki> found = repo.findAll();
        ArrayList<Tsubuyaki> list = new ArrayList<>();
        System.out.println("Kaikki: " + found);
        System.out.println("keyword: " + keyword);
        found.forEach(tsubuyaki -> {
            if (tsubuyaki.getComment().equals(keyword)) {
                list.add(tsubuyaki);
            }
        });
        System.out.println("Loppulista: " + list);
        return list;
    }
}