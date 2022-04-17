import {createRouter, createWebHistory} from 'vue-router';
import Newview from '../views/NewsView.vue';
import JobsView from '../views/JobsView.vue';
import AskView from '../views/AskView.vue';


const router  = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path:'/',
            redirect : '/news'
        },
        {
            path:'/news',
            component: Newview,
        },
        {
            path:'/ask',
            component: AskView,
        },
        {
            path:'/jobs',
            component: JobsView,
        },

    ]
});

export default router;