module.exports = {
  apps : [{
	name : 'bash-script',
    script: './production/bashscript.sh',
    exec_mode : 'cluster',
    instances : 'max',    
    watch: '.',
    env_production : {
      NODE_ENV : 'production'
    }
  }, {
    name: 'bash-dir',
    script: './production/bashdir.sh',
	exec_mode : 'cluster',
    instances : 'max',    
    watch: '.',
	env : {
      NODE_ENV : 'production'
    }
  }],                                                                                      
  deploy : {
    production : {
      'pre-deploy-local': '',
      'post-deploy' : 'pm2 reload ecosystem.config.js --env production',
      'pre-setup': ''
    }
  }
};
