package com.ruoyi.activity.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.activity.mapper.ActivityMapper;
import com.ruoyi.activity.domain.Activity;
import com.ruoyi.activity.service.IActivityService;

/**
 * 活动管理Service业务层处理
 * 
 * @author zhuo
 * @date 2023-12-03
 */
@Service
public class ActivityServiceImpl implements IActivityService 
{
    @Autowired
    private ActivityMapper activityMapper;

    /**
     * 查询活动管理
     * 
     * @param id 活动管理主键
     * @return 活动管理
     */
    @Override
    public Activity selectActivityById(Long id)
    {
        return activityMapper.selectActivityById(id);
    }

    /**
     * 查询活动管理列表
     * 
     * @param activity 活动管理
     * @return 活动管理
     */
    @Override
    public List<Activity> selectActivityList(Activity activity)
    {
        return activityMapper.selectActivityList(activity);
    }

    /**
     * 新增活动管理
     * 
     * @param activity 活动管理
     * @return 结果
     */
    @Override
    public int insertActivity(Activity activity)
    {
        return activityMapper.insertActivity(activity);
    }

    /**
     * 修改活动管理
     * 
     * @param activity 活动管理
     * @return 结果
     */
    @Override
    public int updateActivity(Activity activity)
    {
        return activityMapper.updateActivity(activity);
    }

    /**
     * 批量删除活动管理
     * 
     * @param ids 需要删除的活动管理主键
     * @return 结果
     */
    @Override
    public int deleteActivityByIds(Long[] ids)
    {
        return activityMapper.deleteActivityByIds(ids);
    }

    /**
     * 删除活动管理信息
     * 
     * @param id 活动管理主键
     * @return 结果
     */
    @Override
    public int deleteActivityById(Long id)
    {
        return activityMapper.deleteActivityById(id);
    }
}
