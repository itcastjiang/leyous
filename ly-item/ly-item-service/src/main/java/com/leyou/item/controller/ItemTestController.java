package com.leyou.item.controller;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.entity.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemTestController {

    @PostMapping("/item/save")
    public ResponseEntity<Item> saveItem(Item item){
         if (item.getPrice()==null){
            throw new LyException(ExceptionEnum.BRAND_NOT_FOUND);
//             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("aosdfsdof");
         }

//        return new Item(1,item.getName(),item.getPrice());
         return ResponseEntity.status(HttpStatus.CREATED).body(new Item(1,item.getName(),item.getPrice()));

    }
}
