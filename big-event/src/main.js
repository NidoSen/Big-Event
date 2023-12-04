import './assets/main.scss'

import {
    createApp
} from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from '@/router/index.js'
import {
    createPinia
} from 'pinia'
import {
    createPersistedState
} from 'pinia-persistedstate-plugin'

import App from './App.vue'
import locale from 'element-plus/dist/locale/zh-cn.js'

const app = createApp(App);
const pinia = createPinia();
const persist = createPersistedState();
app.use(router);
app.use(ElementPlus, {
    locale
})
pinia.use(persist);
app.use(pinia);
app.mount('#app')