import { BaseEntity } from './../../shared';

export class PublisherOptJob implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public campaignId?: number,
        public blackListId?: number,
    ) {
    }
}
