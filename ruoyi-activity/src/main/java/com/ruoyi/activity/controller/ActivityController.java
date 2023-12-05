package com.ruoyi.activity.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.activity.domain.Activity;
import com.ruoyi.activity.service.IActivityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动管理Controller
 * 
 * @author zhuo
 * @date 2023-12-03
 */
@RestController
@RequestMapping("/ruoyi-activity/activity")
public class ActivityController extends BaseController
{
    @Autowired
    private IActivityService activityService;

    /**
     * 查询活动管理列表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-activity:activity:list')")
    @GetMapping("/list")
    public TableDataInfo list(Activity activity)
    {
        startPage();
        List<Activity> list = activityService.selectActivityList(activity);
        return getDataTable(list);
    }

    /**
     * 导出活动管理列表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-activity:activity:export')")
    @Log(title = "活动管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Activity activity)
    {
        List<Activity> list = activityService.selectActivityList(activity);
        ExcelUtil<Activity> util = new ExcelUtil<Activity>(Activity.class);
        util.exportExcel(response, list, "活动管理数据");
    }

    /**
     * 获取活动管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-activity:activity:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(activityService.selectActivityById(id));
    }

    /**
     * 新增活动管理
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-activity:activity:add')")
    @Log(title = "活动管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Activity activity)
    {
        return toAjax(activityService.insertActivity(activity));
    }

    /**
     * 修改活动管理
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-activity:activity:edit')")
    @Log(title = "活动管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Activity activity)
    {
        return toAjax(activityService.updateActivity(activity));
    }

    /**
     * 删除活动管理
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-activity:activity:remove')")
    @Log(title = "活动管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(activityService.deleteActivityByIds(ids));
    }
}
