package com.woowahan.recipe.domain.dto.recipeDto;

import com.woowahan.recipe.domain.entity.RecipeEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeCreateReqDto {

    @NotBlank(message = "제목을 입력해주세요.")
    private String recipeTitle;
    @NotBlank(message = "내용을 입력해주세요.")
    private String recipeBody;
    @NotNull(message = "재료를 등록해주세요.")
    private List<String> items;
    @NotNull(message = "이미지를 등록해주세요.")
    private String recipeImagePath;

    public RecipeEntity toEntity(){
        RecipeEntity build = RecipeEntity.builder()
                .id(toEntity().getId())
                .recipeImagePath(recipeImagePath)
                .build();
        return build;
    }

    // 레시피 수정을 위한 set메서드
    public void setFilePath(String recipeImagePath) {
        this.recipeImagePath = recipeImagePath;
    }
}
