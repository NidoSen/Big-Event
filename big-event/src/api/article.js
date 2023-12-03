import request from '@/utils/request.js'
import {
    useTokenStore
} from '@/stores/token.js';

// 文章分类列表查询
export const articleCategoryListService = () => {
    //获取token状态
    const tokenStore = useTokenStore()
    //通过请求头Authorization携带token
    //在pinia中定义的响应式数据，都不需要加.value
    return request.get('/category', {
        headers: {
            'Authorization': tokenStore.token
        }
    })
}