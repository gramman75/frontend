const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
    outputDir: "../src/main/resources/static",

    devServer: {
        proxy : {
            '/api': {
                target : 'http://localhost:9000/',
                ws: true,
                changeOrigin: true
            }
        }
    },

    lintOnSave: false,

    chainWebpack: config => {
        const svgRule = config.module.rule("svg");
        svgRule.uses.clear();
        svgRule.use("vue-svg-loader").loader("vue-svg-loader");
    },

    pluginOptions: {
      vuetify: {
			// https://github.com/vuetifyjs/vuetify-loader/tree/next/packages/vuetify-loader
		}
    }
})
