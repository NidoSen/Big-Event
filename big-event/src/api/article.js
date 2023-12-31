import request from '@/utils/request.js'
import {
    useTokenStore
} from '@/stores/token.js';

// 文章分类列表查询
export const articleCategoryListService = () => {
    //获取token状态
    //const tokenStore = useTokenStore()
    //通过请求头Authorization携带token
    //在pinia中定义的响应式数据，都不需要加.value
    return request.get('/category')
}

//添加文章分类
export const articleCategoryAddService = (categoryModel) => {
    return request.post('/category', categoryModel)
}

//文章分类修改
export const articleCategoryUpdateService = (categoryData) => {
    return request.put('/category', categoryData)
}

//文章分类删除
export const articleCategoryDeleteService = (id) => {
    return request.delete('/category?id=' + id)
}

//文章列表查询
export const articleListService = (params) => {
    return request.get('/article', {
        params: params
    })
}

//添加文章
export const articleAddService = (articleModel) => {
    return request.post('/article', articleModel)
}