package com.ruoyi.activity.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 活动管理对象 activity
 * 
 * @author zhuo
 * @date 2023-12-03
 */
public class Activity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 活动ID */
    private Long id;

    /** 活动名称 */
    @Excel(name = "活动名称")
    private String name;

    /** 活动描述 */
    @Excel(name = "活动描述")
    private String description;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("description", getDescription())
            .toString();
    }
}
