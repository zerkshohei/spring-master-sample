# コマンド実行時のデフォルトシェル
SHELL := bash
# シェルに渡すオプション
# -e 失敗した時点で停止させる
# -u 未定義の変数があったらエラー
# -o -pipefail パイプの途中で失敗したらそこで停止させる
# -c 文字列からコマンドを実行。これ自体は.SHELLFLAGSのデフォルト設定
.SHELLFLAGS := -eu -o pipefail -c

# makeを打った時のコマンド
.DEFAULT_GOAL := help

.PHONY: database-up
database-up: ## データベース起動
	@docker compose -f ./docker/database/compose.yaml up -d

.PHONY: database-down
database-down: ## データベース停止
	docker compose -f ./docker/database/compose.yaml down

.PHONY: redis-up
redis-up: ## Redis起動
	@docker compose -f ./docker/redis/compose.yaml up -d

.PHONY: redis-down
redis-down: ## Redis停止
	docker compose -f ./docker/redis/compose.yaml down

.PHONY: mailhog-up
mailhog-up: ## mailhog起動
	@docker compose -f ./docker/mailhog/compose.yaml up -d

.PHONY: mailhog-down
mailhog-down: ## mailhog停止
	docker compose -f ./docker/mailhog/compose.yaml down

.PHONY: rabbit-mq-up
rabbit-mq-up: ## rabbit-mq起動
	@docker compose -f ./docker/rabbit-mq/compose.yaml up -d

.PHONY: rabbit-mq-down
rabbit-mq-down: ## rabbit-mq停止
	docker compose -f ./docker/rabbit-mq/compose.yaml down


.PHONY: help
help: ## ヘルプ
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-20s\033[0m %s\n", $$1, $$2}'

%: # 打ち間違いのときのコマンド
	@echo 'command "$@" is not found.'
	@$(MAKE) help
	@exit 2

