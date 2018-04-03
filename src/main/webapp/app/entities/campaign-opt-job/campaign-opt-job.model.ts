import { BaseEntity } from './../../shared';

export class CampaignOptJob implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public optimizationPropsId?: number,
        public blacklistId?: number,
        public publishers?: BaseEntity[],
    ) {
    }
}
