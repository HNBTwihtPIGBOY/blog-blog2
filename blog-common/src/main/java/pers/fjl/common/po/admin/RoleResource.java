package pers.fjl.common.po.admin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author fjl
 * @since 2022-01-15
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "角色资源表", description = "角色资源表实体")
@EqualsAndHashCode(callSuper = false)
@TableName("tb_role_resource")
public class RoleResource extends Model<RoleResource> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色id
     */
    private Integer rid;

    /**
     * 权限id
     */
    private Integer resourceId;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
