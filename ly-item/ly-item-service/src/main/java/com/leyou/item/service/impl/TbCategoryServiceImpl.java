package com.leyou.item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.utils.BeanHelper;
import com.leyou.item.entity.TbCategory;
import com.leyou.item.mapper.TbCategoryMapper;
import com.leyou.item.pojo.CategoryDTO;
import com.leyou.item.service.TbCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 商品类目表，类目和商品(spu)是一对多关系，类目与品牌是多对多关系 服务实现类
 * </p>
 *
 * @author HM
 * @since 2019-08-12
 */
@Service
public class TbCategoryServiceImpl extends ServiceImpl<TbCategoryMapper, TbCategory> implements TbCategoryService {

    @Override
    public List<CategoryDTO> findCategoryListByParentId(Long pid) {
//         设置查询条件
        QueryWrapper<TbCategory> queryWrapper = new QueryWrapper<>();
       queryWrapper.lambda().eq(TbCategory::getParentId,pid);
        List<TbCategory> tbCategories = this.list(queryWrapper);
        if (CollectionUtils.isEmpty(tbCategories)){
            throw new LyException(ExceptionEnum.CARTS_NOT_FOUND);
        }
        return BeanHelper.copyWithCollection(tbCategories,CategoryDTO.class);
    }
}
